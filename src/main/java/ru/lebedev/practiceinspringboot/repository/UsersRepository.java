package ru.lebedev.practiceinspringboot.repository;

import org.springframework.data.repository.CrudRepository;
import ru.lebedev.practiceinspringboot.models.Users;

public interface UsersRepository extends CrudRepository<Users, Integer> {
}
