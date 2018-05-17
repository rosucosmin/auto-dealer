package com.siemens.ct.bam.users;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

public class AutoRegister {

    private Map<Long, User> regUsers = new HashMap<>();
    private Map<String, Car> regCars = new HashMap<>();
    private Map<String, Long> regAuto = new HashMap<>();

    public void registerUser(User user) throws AlreadyExistException {
        //Exception if user already exists
        if(existUser(user))
            throw new AlreadyExistException("User already registered... "+ user);

        regUsers.put(user.getCnp(), user);
    }

    public void registerCar(Car car) throws AlreadyExistException {
        //Exception if car already exists
        if(existCar(car))
            throw new AlreadyExistException("Car already registered... "+ car);

        regCars.put(car.getPlateNumber(),car);
    }


    public void alocateCar(Long cnp, String plateNumber)
    {
        //Exception if car already alocated

        regAuto.put(plateNumber,cnp);
    }

    public User getUserForCar(String plateNumber)
    {

        return regUsers.get(regAuto.get(plateNumber));
    }

//    public TreeSet getCarsForUsers(Long cnp)
//    {
//
//    }


    public int getSizeUsers()
    {
        return regUsers.size();
    }

    public int getSizeCars()
    {
        return regCars.size();
    }

    public boolean existUser(User user)
    {
        if(regUsers.containsKey(user.getCnp()))
            return true;

        return false;
    }

    public boolean existCar(Car car)
    {
        if(regUsers.containsKey(car.getPlateNumber()))
            return true;

        return false;
    }

}
