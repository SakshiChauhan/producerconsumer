package com.ekar.prodcom.prodcom.repository;

import com.ekar.prodcom.prodcom.entity.RequestEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RequestEntityRepository extends JpaRepository<RequestEntity,Long> {
}
