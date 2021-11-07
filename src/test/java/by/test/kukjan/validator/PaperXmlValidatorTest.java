package by.test.kukjan.validator;

import by.task.kukjan.exception.PaperException;
import by.task.kukjan.validator.PaperValidator;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PaperXmlValidatorTest {
    @Test
    public void testValidateXmlFile() throws PaperException{
        boolean actual = PaperValidator.validateXMLFile("data/valid.xml");
        Assert.assertTrue(actual);
    }

    @Test
    public void testValidateXMLFileInvalid() throws PaperException {
        boolean actual = PaperValidator.validateXMLFile("data/invalid.xml");
        Assert.assertFalse(actual);
    }
}
