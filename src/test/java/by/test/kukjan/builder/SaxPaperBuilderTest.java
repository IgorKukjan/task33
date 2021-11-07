package by.test.kukjan.builder;

import by.task.kukjan.entity.*;
import by.task.kukjan.exception.PaperException;
import by.task.kukjan.parser.SaxPaperBuilder;
import by.task.kukjan.util.Util;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.MonthDay;
import java.util.HashSet;
import java.util.Set;

public class SaxPaperBuilderTest {
    private SaxPaperBuilder saxBuilder;

    @BeforeTest
    public void initialize() throws PaperException {
        saxBuilder = new SaxPaperBuilder();
    }

    @Test
    public void testBuildPapers() throws PaperException{
        GlossyPaper glossyPaper1 = new GlossyPaper();
        glossyPaper1.setId("b1");
        glossyPaper1.setNote("for everyone");
        glossyPaper1.setTitle("Example Glossy Paper");
        glossyPaper1.setNumberOfPages(3);
        glossyPaper1.setPrice(2);
        glossyPaper1.setMonthly(false);
        glossyPaper1.setColor(true);
        glossyPaper1.setPublicationDate(MonthDay.parse("--02-25"));
        glossyPaper1.setGlossyPaperType(GlossyPaperType.BOOKLET);

        NotGlossyPaper notGlossyPaper1 = new NotGlossyPaper();
        notGlossyPaper1.setId("n1");
        notGlossyPaper1.setNote("-");
        notGlossyPaper1.setTitle("Example Not Glossy Paper");
        notGlossyPaper1.setNumberOfPages(10);
        notGlossyPaper1.setPrice(4);
        notGlossyPaper1.setMonthly(true);
        notGlossyPaper1.setColor(true);
        notGlossyPaper1.setPublicationDate(MonthDay.parse("--02-25"));
        notGlossyPaper1.setNotGlossyPaperType(NotGlossyPaperType.NEWSPAPER);

        Set<AbstractPaper> expectedSet = new HashSet<AbstractPaper>();
        expectedSet.add(glossyPaper1);
        expectedSet.add(notGlossyPaper1);

        Util util = new Util();
        String xmlPath = util.getPath("data/valid.xml");

        saxBuilder.buildPapers(xmlPath);
        Set<AbstractPaper> actualSet = saxBuilder.getPapers();

        Assert.assertEquals(actualSet, expectedSet);
    }
}
