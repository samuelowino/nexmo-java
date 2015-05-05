package com.nexmo.verify.sdk;
/*
 * Copyright (c) 2011-2013 Nexmo Inc
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

import java.util.Date;
import java.util.List;

/**
 * Verification search result.
 * @author Daniele Ricci
 */
public class SearchResult extends BaseResult {

    /** Used to define a verify check attempt. */
    public static class VerifyCheck {
        enum Status {
            VALID,
            INVALID,
        }

        private final Date date;
        private final String code;
        private final Status status;
        private final String ipAddress;

        public VerifyCheck(Date date,
                           String code,
                           Status status,
                           String ipAddress) {
            this.date = date;
            this.code = code;
            this.status = status;
            this.ipAddress = ipAddress;
        }

        public Date getDate() {
            return date;
        }

        public String getCode() {
            return code;
        }

        public Status getStatus() {
            return status;
        }

        public String getIpAddress() {
            return ipAddress;
        }

        @Override
        public String toString() {
            return "VerifyCheck [status=" + status + ", code=" + code + ", date=" + date + "]";
        }
    }

    public enum VerificationStatus {
        IN_PROGRESS("IN PROGRESS"),
        SUCCESS,    // FIXME documented as "SUCCESSFUL"
        FAILED,
        EXPIRED;

        private final String name;

        VerificationStatus() {
            this(null);
        }

        VerificationStatus(String name) {
            this.name = name;
        }

        public String getName() {
            return name != null ? name : name();
        }

        @Override
        public String toString() {
            return getName();
        }
    }

    private final String requestId;
    private final String accountId;
    private final VerificationStatus verificationStatus;
    private final String number;
    private final float price;
    private final String currency;
    private final String senderId;
    private final Date dateSubmitted;
    private final Date dateFinalized;
    private final Date firstEventDate;
    private final Date lastEventDate;
    private final List<VerifyCheck> checks;

    protected SearchResult(final int status,
                           final String requestId,
                           final String accountId,
                           final VerificationStatus verificationStatus,
                           final String number,
                           final float price,
                           final String currency,
                           final String senderId,
                           final Date dateSubmitted,
                           final Date dateFinalized,
                           final Date firstEventDate,
                           final Date lastEventDate,
                           final List<VerifyCheck> checks,
                           final String errorText,
                           final boolean temporaryError) {
        super(status, errorText, temporaryError);
        this.requestId = requestId;
        this.accountId = accountId;
        this.verificationStatus = verificationStatus;
        this.number = number;
        this.price = price;
        this.currency = currency;
        this.senderId = senderId;
        this.dateSubmitted = dateSubmitted;
        this.dateFinalized = dateFinalized;
        this.firstEventDate = firstEventDate;
        this.lastEventDate = lastEventDate;
        this.checks = checks;
    }

    public String getRequestId() {
        return requestId;
    }

    public String getAccountId() {
        return accountId;
    }

    public VerificationStatus getVerificationStatus() {
        return verificationStatus;
    }

    public String getNumber() {
        return number;
    }

    public float getPrice() {
        return price;
    }

    public String getCurrency() {
        return currency;
    }

    public String getSenderId() {
        return senderId;
    }

    public Date getDateSubmitted() {
        return dateSubmitted;
    }

    public Date getDateFinalized() {
        return dateFinalized;
    }

    public Date getFirstEventDate() {
        return firstEventDate;
    }

    public Date getLastEventDate() {
        return lastEventDate;
    }

    public List<VerifyCheck> getChecks() {
        return checks;
    }

    @Override
    public String toString() {
        return "SearchResult [status=" + getStatus() + ", requestId=" + requestId +
                ", verificationStatus=" + verificationStatus + "]";
    }
}