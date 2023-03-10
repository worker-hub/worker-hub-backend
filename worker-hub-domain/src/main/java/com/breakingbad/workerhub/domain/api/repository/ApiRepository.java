package com.breakingbad.workerhub.domain.api.repository;

import com.breakingbad.workerhub.domain.api.Api;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApiRepository extends JpaRepository<Api, Long> {

}
