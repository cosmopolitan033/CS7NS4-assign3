import pandas as pd
import psycopg2
from psycopg2.extras import Json
from datetime import datetime

# Load CSV data
file_path = 'combined_sensor_data.csv'
data = pd.read_csv(file_path)

# Database connection
conn = psycopg2.connect(
    dbname="cs7ns4_db",
    user="myuser",
    password="mypassword",
    host="localhost",
    port="5432"
)
cur = conn.cursor()

# Insert data into PostgreSQL
for _, row in data.iterrows():
    # Check and parse datetime only if it's a string
    datetime_value = None
    if isinstance(row['Datetime'], str):
        try:
            datetime_value = datetime.strptime(row['Datetime'], "%Y-%m-%d %H:%M:%S")
        except ValueError:
            datetime_value = None  # Handle malformed datetime

    cur.execute(
        """
        INSERT INTO sensor_data (serial, type, datetime, data, outlier_flag)
        VALUES (%s, %s, %s, %s, %s)
        """,
        (
            row['Serial'],
            row['Type'],
            datetime_value,
            Json(eval(row['Data'])),
            row['Outlier_Flag']
        )
    )

# Commit and close
conn.commit()
cur.close()
conn.close()
