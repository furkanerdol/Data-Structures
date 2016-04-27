package HW01_131044065_Furkan_Erdol;

/**
 * Document class
 * @author furkan
 */
public abstract class Document implements DocumentInterface {

    private String documantName;

    /**
     * Takes document name
     * @param newDocumentName document name
     */
    public Document(String newDocumentName) {
        setDocumentName(newDocumentName);
    }

    /**
     * Returns document name
     * @return document name
     */
    public String getDocumentName() {
        return documantName;
    }

    /**
     * Modify document name
     * @param newDocumentName document name
     */
    public void setDocumentName(String newDocumentName) {
        documantName = newDocumentName;
    }

    
    /**
     * Override toString method
     * @return document informations as a string
     */
    public String toString() {

        String formatted = new String();

        if (this instanceof Book) {
            Book tempBook = (Book) this;
            formatted += String.format("\n-Book : %s", tempBook.getDocumentName());
        } else if (this instanceof File) {
            File tempFile = (File) this;
            formatted += String.format("\n-File : %s", tempFile.getDocumentName());
        } else if (this instanceof Slide) {
            Slide tempSlide = (Slide) this;
            formatted += String.format("\n-Slide : %s", tempSlide.getDocumentName());
        } else if (this instanceof Url) {
            Url tempUrl = (Url) this;
            formatted += String.format("\n-Url : %s", tempUrl.getDocumentName());
        } else if (this instanceof WhiteBoardDescriptions) {
            WhiteBoardDescriptions tempWhiteBoardDescriptions = (WhiteBoardDescriptions) this;
            formatted += String.format("\n-White Board Description : %s", tempWhiteBoardDescriptions.getDocumentName());
        }

        return formatted;
    }
}
