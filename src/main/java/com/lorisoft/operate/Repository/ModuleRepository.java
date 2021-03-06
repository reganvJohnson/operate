package com.lorisoft.operate.Repository;

import com.lorisoft.operate.entity.Module;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ModuleRepository extends CrudRepository<Module, Integer> {

//    List<Issue> findByYear(String year);
//    //In this case a query annotation is not need since spring constructs the query from the method name
//    //public List<ReleaseDateType> findByCacheMedia_Id(Integer IssueTitle

//   @Query("FROM Issue where lower(articles) like lower(concat('%', ?1,'%'))")
//    List<Issue> findBySimpleQuery(String firstName);

    // Trick here, is that the table in the query, needs to be spelled like the class
    // so I select from Equipment. *sigh
    @Query("select count(*) from Module")
    int moduleCount();

    @Query("select id from Module")
    List<String> findIds();
}
