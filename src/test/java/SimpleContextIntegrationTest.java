import de.siemering.example.AppConfig;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import static org.hamcrest.CoreMatchers.notNullValue;

@ContextConfiguration(classes = AppConfig.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class SimpleContextIntegrationTest {

    @PersistenceContext
    public EntityManager em;

    @Test
    @Transactional
    public void testDBSetup(){
        Assert.assertThat(em, notNullValue());
    }
}
