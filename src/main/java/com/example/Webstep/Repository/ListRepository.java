package com.example.Webstep.Repository;

import com.example.Webstep.Domain.ListEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ListRepository extends JpaRepository<ListEntity, String> {
}
