package com.siemens.ct.bam.users;

import java.util.*;

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


    public void alocateCar(Long cnp, String plateNumber) throws AlreadyAlocatedException {
        //Exception if car already alocated
        if(regAuto.containsKey(plateNumber))
            throw new AlreadyAlocatedException("Car has already an owner: "+ regUsers.get(regAuto.get(plateNumber)));

        regAuto.put(plateNumber,cnp);
    }

    public User getUserForCar(String plateNumber) throws NotAlocatedException {
        //Car is not alocated;
        if(!regAuto.containsKey(plateNumber))
            throw new NotAlocatedException("Car does not have an owner..." + regCars.get(plateNumber));

        return regUsers.get(regAuto.get(plateNumber));
    }

    public HashSet<Car> getCarsForUsers(Long cnp) throws NotAlocatedException {
        //Exception for User without cars;
        if(!regAuto.containsValue(cnp))
            throw new NotAlocatedException("User does not have any cars... " + regUsers.get(cnp));

        HashSet<Car> myCars = new HashSet<>();
        for(Object itPlateNumber: regAuto.keySet())
        {
            if(regAuto.get(itPlateNumber) == cnp)
                myCars.add(regCars.get(itPlateNumber));
        }

        return myCars;
    }

    public HashSet<Car> getCarsFromState(String state)
    {

        HashSet<Car> myCars = new HashSet<>();
        for(String itPlateNumber : regCars.keySet())
            if(itPlateNumber.startsWith(state))
                myCars.add(regCars.get(itPlateNumber));

        return myCars;
    }



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
