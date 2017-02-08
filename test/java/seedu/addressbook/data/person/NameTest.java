package seedu.addressbook.data.person;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import seedu.addressbook.data.exception.IllegalValueException;

public class NameTest {

    @Test
    public void name_equal_returnsTrue() throws IllegalValueException {
        Name name0 = new Name("How Si Wei");
        Name name1 = new Name("How Si Wei");
        assertNameSimilar(name0, name1);
    }

    private void assertNameSimilar(Name name0, Name name1) {
        assertTrue(name0.isSimilar(name1));
    }

    private void assertNameNotSimilar(Name name0, Name name1) {
        assertFalse(name0.isSimilar(name1));
    }

}
