package stepdefinitions;

import com.github.javafaker.Faker;
import exceptions.ValueIsDifferent;
import integrations.ConsultEmployee;
import integrations.ConsultListEmployee;
import integrations.CreateEmployee;
import integrations.DeleteEmployee;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import models.Employee;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import questions.EmpleadoInfo;
import questions.ResponseService;

import java.util.List;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.Matchers.equalTo;
import static utils.UrlServices.URL_SERVICES;

public class ConsultService {
    @Before
    public void prepareTests() {
        OnStage.setTheStage(new OnlineCast());
    }

    @Given("the user wants consume the service")
    public void theUserWantsConsumeTheService() {
        OnStage.theActorCalled("usuario").whoCan(CallAnApi.at(URL_SERVICES.toString()));
    }

    @When("he consult the service")
    public void heConsultTheService() {
        theActorInTheSpotlight().attemptsTo(ConsultListEmployee.of());
    }

    @When("he call the service and create the employee")
    public void heCallTheServiceAndCreateTheEmployee() {
        Faker faker = new Faker();
        theActorInTheSpotlight().attemptsTo(CreateEmployee.on(new Employee(faker.number().randomDigit(), faker.name().fullName().toString(), faker.number().numberBetween(1000000, 5000000), faker.number().numberBetween(18, 60))));
    }

    @Then("he should see that the employee has been saved")
    public void heShouldSeeThatTheEmployeeHasBeenSaved() {
        theActorInTheSpotlight().should(seeThat(ResponseService.of(), equalTo("success"))
                .orComplainWith(ValueIsDifferent.class, "error to save the employee"));
    }

    @When("he call the service and response is ok")
    public void heCallTheServiceAndResponseIsOk() {
        theActorInTheSpotlight().should(seeThat(ResponseService.of(), equalTo("success"))
                .orComplainWith(ValueIsDifferent.class, "error to save the employee"));
    }

    @Then("his should by see all information of employee")
    public void hisShouldBySeeAllInformationOfEmployee(List<Employee> employees) {
        if (employees.get(0).getProfileImage() == null) {
            employees.get(0).setProfileImage("");
        }
        System.out.println("Hola " + employees.get(0).toString());
        theActorInTheSpotlight().should(seeThat(EmpleadoInfo.is(), equalTo(employees.get(0).toString()))
                .orComplainWith(ValueIsDifferent.class, "error consult data of employee")
        );
    }

    @When("he call the service for delete employee with {int}")
    public void heCallTheServiceForDeleteEmployeeWith(Integer id) {
        theActorInTheSpotlight().attemptsTo(DeleteEmployee.byId(String.valueOf(id)));
    }

    @Then("should by see the employee is delete")
    public void shouldBySeeTheEmployeeIsDelete() {
        theActorInTheSpotlight().should(seeThat(ResponseService.of(), equalTo("success"))
                .orComplainWith(ValueIsDifferent.class, "error to delete the employee"));
    }

    @When("he consult the service for employee specific {int}")
    public void heConsultTheServiceForEmployeeSpecific(Integer id) {
        theActorInTheSpotlight().attemptsTo(ConsultEmployee.byId(String.valueOf(id)));
    }
    @Then("his should by see the list of employees")
    public void hisShouldBySeeTheListOfEmployees() {
        theActorInTheSpotlight().should(seeThat(ResponseService.of(), equalTo("success"))
                .orComplainWith(ValueIsDifferent.class, "error to consult employees"));
    }
}
