package by.test.kukjan.builder;

import by.task.kukjan.builder.AbstractPaperBuilder;
import by.task.kukjan.builder.PaperBuilderFactory;
import by.task.kukjan.exception.PaperException;
import by.task.kukjan.parser.DomPaperBuilder;
import by.task.kukjan.parser.SaxPaperBuilder;
import by.task.kukjan.parser.StaxPaperBuilder;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class PaperBuilderFactoryTest {

    @DataProvider(name = "providerBuilder")
    public Object[][] createData(){
        return new Object[][]{
                {"sax", SaxPaperBuilder.class},
                {"dom", DomPaperBuilder.class},
                {"stax", StaxPaperBuilder.class},
        };
    }

    @Test(dataProvider = "providerBuilder")
    public void testCreateBuilderPositive(String typeParser, Class<? extends AbstractPaperBuilder> expected) throws PaperException{
        Class<? extends AbstractPaperBuilder> actual = PaperBuilderFactory.createPaperBuilder(typeParser).getClass();
        Assert.assertEquals(actual, expected);
    }

    @Test(expectedExceptions = PaperException.class)
    public void testCreateBuilderException() throws PaperException{
       PaperBuilderFactory.createPaperBuilder("jjj");
    }

}
