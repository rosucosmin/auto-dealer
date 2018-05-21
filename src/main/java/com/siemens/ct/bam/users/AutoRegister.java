package com.siemens.ct.bam.users;

import java.util.*;

public class AutoRegister {

    private Map<Long, User> regUsers = new HashMap<>();
    private Map<String, Car> regCars = new HashMap<>();
    private Map<String, HashSet<Long>> regAuto = new HashMap<>();

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


    public void alocateCar(Long cnp, String plateNumber) throws AlreadyAlocatedException, CarDoesNotExistException, UserNotRegistered {
        if(regCars.get(plateNumber)==null)
            throw new CarDoesNotExistException("Car is not registered... " + regCars.get(plateNumber));

        if(regUsers.get(cnp)==null)
            throw new UserNotRegistered("User is not registerd... " + regUsers.get(cnp));

        //Exception if car already alocated
        if(!regAuto.containsKey(plateNumber)) {
            HashSet<Long> drivers = new HashSet<>();
            drivers.add(cnp);
            regAuto.put(plateNumber, drivers);
        }
        else
        {
            regAuto.get(plateNumber).add(cnp);
        }

    }



    public HashSet<User> getUserForCar(String plateNumber) throws NotAlocatedException {
        //Car is not alocated;
        if(!regAuto.containsKey(plateNumber))
            throw new NotAlocatedException("Car does not have an owner..." + regCars.get(plateNumber));

        HashSet<User> drivers = new HashSet<>();
        for (Long cnp: regAuto.get(plateNumber))
            drivers.add(regUsers.get(cnp));

        return drivers;
    }

    public HashSet<Car> getCarsForUsers(Long cnp) throws NotAlocatedException {
        //Exception for User without cars;
//        if(!regAuto.containsValue(cnp))
//            throw new NotAlocatedException("User does not have any cars... " + regUsers.get(cnp));

        HashSet<Car> myCars = new HashSet<>();
        int count = 0;
        for(Object itPlateNumber: regAuto.keySet())
            for(Long itcnp : regAuto.get(itPlateNumber))
                if(itcnp.equals(cnp)) {
                    myCars.add(regCars.get(itPlateNumber));
                    count++;
                }
        if(count < 1)
            throw new NotAlocatedException("User does not have any cars... " + regUsers.get(cnp));

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
        if(regCars.containsKey(car.getPlateNumber()))
            return true;

        return false;
    }

    public int getSizeAutoReg()
    {
        return regAuto.size();
    }

}
