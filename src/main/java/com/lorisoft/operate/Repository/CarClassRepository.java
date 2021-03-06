package com.lorisoft.operate.Repository;

import com.lorisoft.operate.entity.CarClass;
import org.springframework.data.repository.CrudRepository;

public interface CarClassRepository extends CrudRepository<CarClass, Integer> {

//    List<Issue> findByYear(String year);
//    //In this case a query annotation is not need since spring constructs the query from the method name
//    //public List<ReleaseDateType> findByCacheMedia_Id(Integer IssueTitle

//   @Query("FROM Issue where lower(articles) like lower(concat('%', ?1,'%'))")
//    List<Issue> findBySimpleQuery(String firstName);

}
