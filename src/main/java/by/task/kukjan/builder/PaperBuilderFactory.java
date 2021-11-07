package by.task.kukjan.builder;

import by.task.kukjan.exception.PaperException;
import by.task.kukjan.parser.DomPaperBuilder;
import by.task.kukjan.parser.SaxPaperBuilder;
import by.task.kukjan.parser.StaxPaperBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class PaperBuilderFactory {
    static Logger logger = LogManager.getLogger();
    private enum ParserType {
        DOM, SAX, STAX
    }

    private PaperBuilderFactory() { }

    public static AbstractPaperBuilder createPaperBuilder(String parserType) throws PaperException {
        try {
            ParserType type = ParserType.valueOf(parserType.toUpperCase());

            return switch (type) {
                case DOM -> new DomPaperBuilder();
                case SAX -> new SaxPaperBuilder();
                case STAX -> new StaxPaperBuilder();
            };
        } catch (IllegalArgumentException e) {
            String errorMsg = "Parser with name '" + parserType + "' not found";
            logger.error(errorMsg);
            throw new PaperException(errorMsg, e);
        }
    }
}
