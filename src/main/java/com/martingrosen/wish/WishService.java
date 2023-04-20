package com.martingrosen.wish;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WishService {
    @Autowired private WishRepository repo;

    public List<Wish> listAll() { return (List<Wish>) repo.findAll(); }

    public void save(Wish wish) { repo.save(wish); }

    public Wish get(Integer id) throws UserNotFoundException {
        Optional<Wish> result = repo.findById(id);
        if (result.isPresent()) {
            return result.get();
        }
        throw new UserNotFoundException("Could not find any wishes with ID " + id);
    }

    public void delete(Integer id) throws UserNotFoundException {
        Long count = repo.countById(id);
        if (count == null || count == 0) {
            throw new UserNotFoundException("Could not find any wishes with ID " + id);
        }
        repo.deleteById(id);
    }
}
