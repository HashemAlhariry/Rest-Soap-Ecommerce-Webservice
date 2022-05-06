package backend.exceptions.exptionsdtos;

import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class AccountErrorMessage {
    private String errorMessage;
    private int errorCode;
    private String errorDescription;

    public AccountErrorMessage() {
    }

    public AccountErrorMessage(String errorMessage, int errorCode, String errorDescription) {
        this.errorMessage = errorMessage;
        this.errorCode = errorCode;
        this.errorDescription = errorDescription;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorDescription() {
        return errorDescription;
    }

    public void setErrorDescription(String errorDescription) {
        this.errorDescription = errorDescription;
    }
}
