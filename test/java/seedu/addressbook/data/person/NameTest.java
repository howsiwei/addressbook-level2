package seedu.addressbook.data.person;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import seedu.addressbook.data.exception.IllegalValueException;

public class NameTest {

    private void assertNameSimilar(Name name0, Name name1) {
        assertTrue(name0.isSimilar(name1));
    }

    private void assertNameNotSimilar(Name name0, Name name1) {
        assertFalse(name0.isSimilar(name1));
    }

}
