package com.martingrosen.wish;

import org.springframework.data.repository.CrudRepository;

public interface WishRepository extends CrudRepository<Wish, Integer> {
    public Long countById(Integer id);
}
