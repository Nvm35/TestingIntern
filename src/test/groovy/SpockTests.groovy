import com.testingintern.TestingInternApplication
import com.testingintern.entity.Location
import com.testingintern.entity.Person
import com.testingintern.entity.UserLocation
import com.testingintern.repos.LocationRepository
import com.testingintern.repos.PersonRepository
import com.testingintern.repos.UserLocationRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.web.servlet.MockMvc
import spock.lang.Specification

@SpringBootTest(classes = TestingInternApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class SpockTests extends Specification {

    @Autowired
    PersonRepository personRepository

    @Autowired
    LocationRepository locationRepository

    @Autowired
    UserLocationRepository userLocationRepository


    def "should create and retrieve a person, I need Henry"() {
        given:
        def person = new Person(name: "Henry Cavill", email: "superman@dc.com", id: 4)

        when:
        personRepository.save(person)
        List<Person> people = personRepository.findAll()

        then:
        println "All people in PersonRepository:"
        people.each { println "${it.name}, ${it.email}" }
    }

    def "should create and retrieve a location"() {
        given:
        def location = new Location(locationName: "Krypton", address: "22 Meteorit, Space, Galaxy", id: 4)

        when:
        locationRepository.save(location)
        List<Person> locations = locationRepository.findAll()

        then:
        locations.each { println "${it.locationName},${it.address}" }
    }

    def "should create and share location"() {
        given:
        def pedro = new Person(name: "Pedro Pascal", email: "madalorian@disney.com", id: 4)
        personRepository.save(pedro)
        def location1 = new Location(locationName: "Office", address: "123 Florida, USA", id: 4)
        locationRepository.save(location1)
        def location2 = new Location(locationName: "Home", address: "456 Alabama, USA", id: 5)
        locationRepository.save(location2)
        def perdoInDaHouse = new UserLocation(person: 1, location: 200, accessLevel: "lazy", id: 6)
        userLocationRepository.save(perdoInDaHouse)


        when:
        List<Person> userLocations = userLocationRepository.findByPersonId(4)
        List<Person> locations = locationRepository.findAll()


        then:
        locations.each { println "${it.locationName},${it.address}" }
        userLocations.each {
            println "${it.person_id}, ${it.location_id},${it.accessLevel}"
        }


    }
}



