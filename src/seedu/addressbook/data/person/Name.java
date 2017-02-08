package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Represents a Person's name in the address book.
 * Guarantees: immutable; is valid as declared in {@link #isValidName(String)}
 */
public class Name {

    public static final String EXAMPLE = "John Doe";
    public static final String MESSAGE_NAME_CONSTRAINTS = "Person names should be spaces or alphabetic characters";
    public static final String NAME_VALIDATION_REGEX = "[\\p{Alpha} ]+";
    public final String fullName;

    /**
     * Validates given name.
     *
     * @throws IllegalValueException if given name string is invalid.
     */
    public Name(String name) throws IllegalValueException {
        String trimmedName = name.trim();
        if (!isValidName(trimmedName)) {
            throw new IllegalValueException(MESSAGE_NAME_CONSTRAINTS);
        }
        this.fullName = trimmedName;
    }

    /**
     * Returns true if a given string is a valid person name.
     */
    public static boolean isValidName(String test) {
        return test.matches(NAME_VALIDATION_REGEX);
    }

    /**
     * Retrieves a listing of every word in the name, in order.
     */
    public List<String> getWordsInName() {
        return Arrays.asList(fullName.split("\\s+"));
    }

    @Override
    public String toString() {
        return fullName;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Name // instanceof handles nulls
                && this.fullName.equals(((Name) other).fullName)); // state check
    }

    /**
     * Returns true of the other name is very similar to this name.
     * Two names are considered similar if ...
     */
    public boolean isSimilar(Name other) {
        if (other == this) {
            return true;
        }
        if (!(other instanceof Name)) {
            return false;
        }
        List<String> wordsInNameLowerCase = this.getWordsInName().stream().map(w -> w.toLowerCase())
                .collect(Collectors.toList());
        List<String> wordsInOtherLowerCase = other.getWordsInName().stream().map(w -> w.toLowerCase())
                .collect(Collectors.toList());
        if (wordsInNameLowerCase.equals(wordsInOtherLowerCase)) {
            return true;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return fullName.hashCode();
    }

}
