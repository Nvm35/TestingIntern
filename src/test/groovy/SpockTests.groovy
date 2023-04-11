import com.testingintern.TestingInternApplication
import com.testingintern.entity.Person
import com.testingintern.repos.LocationRepository
import com.testingintern.repos.PersonRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import spock.lang.Specification

@SpringBootTest(classes = TestingInternApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class SpockTests extends Specification {

    @Autowired
    PersonRepository personRepository

    @Autowired
    LocationRepository locationRepository

    def "should create and retrieve a person, I need Henry"() {
        given:
        def person = new Person(name: "Henry Cavill", email: "superman@dc.com",id: 4)

        when:
        personRepository.save(person)
        List<Person> people =personRepository.findAll()

        then:
        println "All people in PersonRepository:"
        people.each { println "${it.name}, ${it.email}" }
    }

    def "what"() {
        expect:
        1 == 1
    }
}
