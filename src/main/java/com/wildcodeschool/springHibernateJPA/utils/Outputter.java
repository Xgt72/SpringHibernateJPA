package com.wildcodeschool.springHibernateJPA.utils;

import com.wildcodeschool.springHibernateJPA.entities.Car;
import com.wildcodeschool.springHibernateJPA.repositories.CarRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Outputter implements CommandLineRunner {

    private Logger LOG = LoggerFactory.getLogger("CarCollector");

    @Autowired
    private CarRepository carRepository;

    @Override
    public void run(String... args) throws Exception {

        LOG.info("***************");
        LOG.info("Objects in DB : " + carRepository.count());

        Car nsx = new Car("Honda", "NSX", "red", 308, 581);
        LOG.info("***************");
        LOG.info(nsx + " has been created !");
        carRepository.save(nsx);
        LOG.info(nsx + " has been saved !");

        Car civic = new Car("Honda", "Civic", "blue", 215, 142);
        LOG.info("***************");
        LOG.info(civic + " has been created !");
        carRepository.save(civic);
        LOG.info(civic + " has been saved !");

        Car s2000 = new Car("Honda", "S2000", "orange", 240, 241);
        LOG.info("***************");
        LOG.info(s2000 + " has been created !");
        carRepository.save(s2000);
        LOG.info(s2000 + " has been saved !");

        Car integra = new Car("Honda", "Integra", "white", 233, 190);
        LOG.info("***************");
        LOG.info(integra + " has been created !");
        carRepository.save(integra);
        LOG.info(integra + " has been saved !");

        Car tempCar = carRepository.findById(3L).get();
        LOG.info("***************");
        LOG.info("Third car's brand is " + tempCar.getBrand());
        LOG.info("Third car's model is " + tempCar.getModel());
        LOG.info("Third car's color is " + tempCar.getColor());
        LOG.info("Third car's max speed is " + tempCar.getMaxSpeed() + "km/h");
        LOG.info("Third car's power is " + tempCar.getPower() + "ch");

        LOG.info("***************");
        LOG.info("Cars in list are ");
        for (Car myCar : carRepository.findAll()) {
            LOG.info(myCar.toString());
        }

        carRepository.deleteById(2L);


        LOG.info("***************");
        LOG.info("Cars in list are ");
        for (Car myCar : carRepository.findAll()) {
            LOG.info(myCar.toString());
        }

        s2000 = carRepository.findById(3L).get();
        s2000.setColor("green");
        carRepository.save(s2000);
        LOG.info("***************");
        LOG.info(s2000 + " has been updated !");

        LOG.info("***************");
        LOG.info("Cars in list are ");
        for (Car myCar : carRepository.findAll()) {
            LOG.info(myCar.toString());
        }
    }

}
