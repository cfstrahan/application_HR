package repositories;

import com.astontech.hr.configuration.RepositoryConfiguration;
import com.astontech.hr.domain.Element;
import com.astontech.hr.domain.ElementType;
import com.astontech.hr.repositories.ElementRepository;
import com.astontech.hr.repositories.ElementTypeRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = {RepositoryConfiguration.class})
public class ElementRepositoryTest {

    @Autowired
    private ElementRepository elementRepository;

    @Autowired
    private ElementTypeRepository elementTypeRepository;

    @Test
    public void testSaveElement() {
        Element element = new Element();
        element.setElementName("Phone");

        assertNull(element.getId());
        elementRepository.save(element);
        assertNotNull(element.getId());

        Element fetchedElement = elementRepository.findOne(element.getId());
        assertNotNull(fetchedElement);
        assertEquals(element.getId(), fetchedElement.getId());

        fetchedElement.setElementName("Email");
        elementRepository.save(fetchedElement);

        Element updatedElement = elementRepository.findOne(fetchedElement.getId());
        assertEquals(updatedElement.getElementName(), "Email");


    }

    @Test
    public void testSaveElementList(){
        List<Element> elementList = new ArrayList<>();

        elementList.add(new Element("Phone"));
        elementList.add(new Element("Email"));
        elementList.add(new Element("Laptop"));
        elementList.add(new Element("PayRate"));

        elementRepository.save(elementList);

        Iterable<Element> fetchedElementList = elementRepository.findAll();

        int count = 0;
        for (Element element: fetchedElementList) {
            count = count +1;
            System.out.println("count " + count + " " + element.getElementName());

        }

//        assertEquals(5, count);
    }

    @Test
    public void testFindByName(){
        Element element = new Element("FindSingleTest");
        elementRepository.save(element);

        Element foundByNameElement = elementRepository.findByElementName("FindSingleTest");

        assertEquals(element.getId(), foundByNameElement.getId());
    }
    @Test
    public void testFindAllByName(){
        Element element1 = new Element("FindTest");
        elementRepository.save(element1);
        Element element2 = new Element("FindTest");
        elementRepository.save(element2);
        Element element3 = new Element("FindTest");
        elementRepository.save(element3);
        Element element4 = new Element("FindTest");
        elementRepository.save(element4);

        List<Element> foundAllByNameElement = elementRepository.findAllByElementName("FindTest");

        assertEquals(4, foundAllByNameElement.size());
    }
    @Test
    public void testFindById(){
        Element elementTest = new Element("FindThisElement");
        elementRepository.save(elementTest);

        Element foundById = elementRepository.findById(1);

        assertEquals(elementTest.getId(), foundById.getId());

    }
    @Test
    public void testFindByDistinct(){
        Element elementDistinct = new Element("WhoaThereElement");
        elementRepository.save(elementDistinct);

        Element foundDistinct = elementRepository.findDistinctByElementName("WhoaThereElement");

        assertEquals(elementDistinct.getElementName(), foundDistinct.getElementName());

    }
    @Test
    public void testFindElementType(){
        Element element1 = new Element("FindTest");
        elementRepository.save(element1);
        Element element2 = new Element("FindTest");
        elementRepository.save(element2);
        Element element3 = new Element("FindTest");
        elementRepository.save(element3);
        Element element4 = new Element("FindTest");
        elementRepository.save(element4);

        List<Element> elementTypeTest = elementRepository.findAllByElementName("FindTest");

        ElementType elementType = new ElementType("NewType", elementTypeTest);
        elementTypeRepository.save(elementType);

        ElementType foundElementType = elementTypeRepository.findByElementTypeName("NewType");

        assertEquals("NewType", foundElementType.getElementTypeName() );

    }
}
