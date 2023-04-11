import com.testingintern.TestingInternApplication
import com.testingintern.entity.Person
import com.testingintern.repos.LocationRepository
import com.testingintern.repos.PersonRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.web.servlet.MockMvc
import spock.lang.Specification

@SpringBootTest(classes = TestingInternApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class SpockTests extends Specification {

//    @Autowired
//    MockMvc mockMvc

    @Autowired
    PersonRepository personRepository

    @Autowired
    LocationRepository locationRepository


    def "should create and retreve a person, I need Henry"() {
        given:
        def person = new Person(name: "Henry Cavill", email: "superman@dc.com")


        when:
        personRepository.save(person)

        then:
        person.getName()
        println person.email
    }

    def "what"() {
        expect:
        1==1
    }
}
