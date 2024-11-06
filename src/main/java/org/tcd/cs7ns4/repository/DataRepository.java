package org.tcd.cs7ns4.repository;

import org.tcd.cs7ns4.entity.DataEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DataRepository extends JpaRepository<DataEntity, Long> {
}
