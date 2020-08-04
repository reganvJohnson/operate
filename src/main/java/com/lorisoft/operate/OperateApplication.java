package com.lorisoft.operate;

import com.lorisoft.operate.entity.Equipment;
import com.lorisoft.operate.entity.EquipmentRepository;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class OperateApplication {

	public static void main(String[] args) {
		SpringApplication.run(OperateApplication.class, args);
	}



	@Bean
	ApplicationRunner init(EquipmentRepository repository) {
		System.out.println("REGANXXXXXXXXXXXXXXXXXXXXXXXXXXXX");

		return args -> {
			//repository.findAll().forEach(System.out::println);
			for (Equipment equipmentRegister : repository.findAll()) {
				System.out.println(equipmentRegister.toString());
			}
			System.out.println("REGANYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYY");
		};
	}
}
