package com.arcade.batchserviceinmemory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;

public class EmployeeItemProcessor implements ItemProcessor<EmployeeModel, EmployeeModel> {

    private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeItemProcessor.class);

    @Override
    public EmployeeModel process(final EmployeeModel employee) throws Exception {
        String firstname = employee.getFirstname().toUpperCase();
        String place = employee.getPlace().toUpperCase();
        String team = "Paytm Money : " + employee.getTeam().toUpperCase();

        EmployeeModel newEmployee = new EmployeeModel(firstname, place, team);

        LOGGER.info("Converting ( {} ) into ( {} )", employee, newEmployee);

        return newEmployee;
    }
}
