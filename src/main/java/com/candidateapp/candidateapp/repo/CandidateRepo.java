/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.candidateapp.candidateapp.repo;

import com.candidate.entity.Candidate;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author actnow
 */
public interface CandidateRepo extends CrudRepository<Candidate, Long> {
    
    @Query("SELECT c FROM Candidate c")
    public List<Candidate> findAllCandidate();
    
    @Query("SELECT c FROM Candidate c WHERE LOWER(c.fullName) LIKE LOWER(:name)")
    public List<Candidate> findByName(@Param("name") String name);

    public void delete(Long id);
    
}
