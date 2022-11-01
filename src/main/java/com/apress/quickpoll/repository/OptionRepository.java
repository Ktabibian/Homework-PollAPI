package com.apress.quickpoll.repository;

import com.apress.quickpoll.domain.Options;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OptionRepository extends CrudRepository<Options, Long> {
}
