package com.example.test1.Repo1;
import com.example.test1.domenModel.Actor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActorRepo extends JpaRepository<Actor, Integer> {


}
