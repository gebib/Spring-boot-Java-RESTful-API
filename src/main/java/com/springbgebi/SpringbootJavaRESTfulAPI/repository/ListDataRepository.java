package com.springbgebi.SpringbootJavaRESTfulAPI.repository;

import com.springbgebi.SpringbootJavaRESTfulAPI.model.ListData;
import org.springframework.data.jpa.repository.JpaRepository;

//                                                      JPA entity, PK type
public interface ListDataRepository extends JpaRepository<ListData, Long> {
}
