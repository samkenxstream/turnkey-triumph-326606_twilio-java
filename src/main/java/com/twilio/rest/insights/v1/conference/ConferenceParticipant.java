/**
 * This code was generated by
 * \ / _    _  _|   _  _
 *  | (_)\/(_)(_|\/| |(/_  v1.0.0
 *       /       /
 */

package com.twilio.rest.insights.v1.conference;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.twilio.base.Resource;
import com.twilio.converter.Converter;
import com.twilio.converter.DateConverter;
import com.twilio.converter.Promoter;
import com.twilio.exception.ApiConnectionException;
import com.twilio.exception.ApiException;
import com.twilio.exception.RestException;
import com.twilio.http.HttpMethod;
import com.twilio.http.Request;
import com.twilio.http.Response;
import com.twilio.http.TwilioRestClient;
import com.twilio.rest.Domains;
import lombok.ToString;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
@ToString
public class ConferenceParticipant extends Resource {
    private static final long serialVersionUID = 53685364073316L;

    public enum CallDirection {
        INBOUND("inbound"),
        OUTBOUND("outbound");

        private final String value;

        private CallDirection(final String value) {
            this.value = value;
        }

        public String toString() {
            return value;
        }

        /**
         * Generate a CallDirection from a string.
         * @param value string value
         * @return generated CallDirection
         */
        @JsonCreator
        public static CallDirection forValue(final String value) {
            return Promoter.enumFromString(value, CallDirection.values());
        }
    }

    public enum CallStatus {
        ANSWERED("answered"),
        COMPLETED("completed"),
        BUSY("busy"),
        FAIL("fail"),
        NOANSWER("noanswer"),
        RINGING("ringing"),
        CANCELED("canceled");

        private final String value;

        private CallStatus(final String value) {
            this.value = value;
        }

        public String toString() {
            return value;
        }

        /**
         * Generate a CallStatus from a string.
         * @param value string value
         * @return generated CallStatus
         */
        @JsonCreator
        public static CallStatus forValue(final String value) {
            return Promoter.enumFromString(value, CallStatus.values());
        }
    }

    public enum JitterBufferSize {
        LARGE("large"),
        SMALL("small"),
        MEDIUM("medium"),
        OFF("off");

        private final String value;

        private JitterBufferSize(final String value) {
            this.value = value;
        }

        public String toString() {
            return value;
        }

        /**
         * Generate a JitterBufferSize from a string.
         * @param value string value
         * @return generated JitterBufferSize
         */
        @JsonCreator
        public static JitterBufferSize forValue(final String value) {
            return Promoter.enumFromString(value, JitterBufferSize.values());
        }
    }

    public enum Region {
        US1("us1"),
        US2("us2"),
        AU1("au1"),
        BR1("br1"),
        IE1("ie1"),
        JP1("jp1"),
        SG1("sg1"),
        DE1("de1");

        private final String value;

        private Region(final String value) {
            this.value = value;
        }

        public String toString() {
            return value;
        }

        /**
         * Generate a Region from a string.
         * @param value string value
         * @return generated Region
         */
        @JsonCreator
        public static Region forValue(final String value) {
            return Promoter.enumFromString(value, Region.values());
        }
    }

    public enum CallType {
        CARRIER("carrier"),
        CLIENT("client"),
        SIP("sip");

        private final String value;

        private CallType(final String value) {
            this.value = value;
        }

        public String toString() {
            return value;
        }

        /**
         * Generate a CallType from a string.
         * @param value string value
         * @return generated CallType
         */
        @JsonCreator
        public static CallType forValue(final String value) {
            return Promoter.enumFromString(value, CallType.values());
        }
    }

    public enum ProcessingState {
        COMPLETE("complete"),
        IN_PROGRESS("in_progress"),
        TIMEOUT("timeout");

        private final String value;

        private ProcessingState(final String value) {
            this.value = value;
        }

        public String toString() {
            return value;
        }

        /**
         * Generate a ProcessingState from a string.
         * @param value string value
         * @return generated ProcessingState
         */
        @JsonCreator
        public static ProcessingState forValue(final String value) {
            return Promoter.enumFromString(value, ProcessingState.values());
        }
    }

    /**
     * Create a ConferenceParticipantFetcher to execute fetch.
     *
     * @param pathConferenceSid Conference SID.
     * @param pathParticipantSid Participant SID.
     * @return ConferenceParticipantFetcher capable of executing the fetch
     */
    public static ConferenceParticipantFetcher fetcher(final String pathConferenceSid,
                                                       final String pathParticipantSid) {
        return new ConferenceParticipantFetcher(pathConferenceSid, pathParticipantSid);
    }

    /**
     * Create a ConferenceParticipantReader to execute read.
     *
     * @param pathConferenceSid Conference SID.
     * @return ConferenceParticipantReader capable of executing the read
     */
    public static ConferenceParticipantReader reader(final String pathConferenceSid) {
        return new ConferenceParticipantReader(pathConferenceSid);
    }

    /**
     * Converts a JSON String into a ConferenceParticipant object using the provided
     * ObjectMapper.
     *
     * @param json Raw JSON String
     * @param objectMapper Jackson ObjectMapper
     * @return ConferenceParticipant object represented by the provided JSON
     */
    public static ConferenceParticipant fromJson(final String json, final ObjectMapper objectMapper) {
        // Convert all checked exceptions to Runtime
        try {
            return objectMapper.readValue(json, ConferenceParticipant.class);
        } catch (final JsonMappingException | JsonParseException e) {
            throw new ApiException(e.getMessage(), e);
        } catch (final IOException e) {
            throw new ApiConnectionException(e.getMessage(), e);
        }
    }

    /**
     * Converts a JSON InputStream into a ConferenceParticipant object using the
     * provided ObjectMapper.
     *
     * @param json Raw JSON InputStream
     * @param objectMapper Jackson ObjectMapper
     * @return ConferenceParticipant object represented by the provided JSON
     */
    public static ConferenceParticipant fromJson(final InputStream json, final ObjectMapper objectMapper) {
        // Convert all checked exceptions to Runtime
        try {
            return objectMapper.readValue(json, ConferenceParticipant.class);
        } catch (final JsonMappingException | JsonParseException e) {
            throw new ApiException(e.getMessage(), e);
        } catch (final IOException e) {
            throw new ApiConnectionException(e.getMessage(), e);
        }
    }

    private final String participantSid;
    private final String label;
    private final String conferenceSid;
    private final String callSid;
    private final String accountSid;
    private final ConferenceParticipant.CallDirection callDirection;
    private final String from;
    private final String to;
    private final ConferenceParticipant.CallStatus callStatus;
    private final String countryCode;
    private final Boolean isModerator;
    private final ZonedDateTime joinTime;
    private final ZonedDateTime leaveTime;
    private final Integer durationSeconds;
    private final Integer outboundQueueLength;
    private final Integer outboundTimeInQueue;
    private final ConferenceParticipant.JitterBufferSize jitterBufferSize;
    private final Boolean isCoach;
    private final List<String> coachedParticipants;
    private final ConferenceParticipant.Region participantRegion;
    private final ConferenceParticipant.Region conferenceRegion;
    private final ConferenceParticipant.CallType callType;
    private final ConferenceParticipant.ProcessingState processingState;
    private final Map<String, Object> properties;
    private final Map<String, Object> events;
    private final Map<String, Object> metrics;
    private final URI url;

    @JsonCreator
    private ConferenceParticipant(@JsonProperty("participant_sid")
                                  final String participantSid,
                                  @JsonProperty("label")
                                  final String label,
                                  @JsonProperty("conference_sid")
                                  final String conferenceSid,
                                  @JsonProperty("call_sid")
                                  final String callSid,
                                  @JsonProperty("account_sid")
                                  final String accountSid,
                                  @JsonProperty("call_direction")
                                  final ConferenceParticipant.CallDirection callDirection,
                                  @JsonProperty("from")
                                  final String from,
                                  @JsonProperty("to")
                                  final String to,
                                  @JsonProperty("call_status")
                                  final ConferenceParticipant.CallStatus callStatus,
                                  @JsonProperty("country_code")
                                  final String countryCode,
                                  @JsonProperty("is_moderator")
                                  final Boolean isModerator,
                                  @JsonProperty("join_time")
                                  final String joinTime,
                                  @JsonProperty("leave_time")
                                  final String leaveTime,
                                  @JsonProperty("duration_seconds")
                                  final Integer durationSeconds,
                                  @JsonProperty("outbound_queue_length")
                                  final Integer outboundQueueLength,
                                  @JsonProperty("outbound_time_in_queue")
                                  final Integer outboundTimeInQueue,
                                  @JsonProperty("jitter_buffer_size")
                                  final ConferenceParticipant.JitterBufferSize jitterBufferSize,
                                  @JsonProperty("is_coach")
                                  final Boolean isCoach,
                                  @JsonProperty("coached_participants")
                                  final List<String> coachedParticipants,
                                  @JsonProperty("participant_region")
                                  final ConferenceParticipant.Region participantRegion,
                                  @JsonProperty("conference_region")
                                  final ConferenceParticipant.Region conferenceRegion,
                                  @JsonProperty("call_type")
                                  final ConferenceParticipant.CallType callType,
                                  @JsonProperty("processing_state")
                                  final ConferenceParticipant.ProcessingState processingState,
                                  @JsonProperty("properties")
                                  final Map<String, Object> properties,
                                  @JsonProperty("events")
                                  final Map<String, Object> events,
                                  @JsonProperty("metrics")
                                  final Map<String, Object> metrics,
                                  @JsonProperty("url")
                                  final URI url) {
        this.participantSid = participantSid;
        this.label = label;
        this.conferenceSid = conferenceSid;
        this.callSid = callSid;
        this.accountSid = accountSid;
        this.callDirection = callDirection;
        this.from = from;
        this.to = to;
        this.callStatus = callStatus;
        this.countryCode = countryCode;
        this.isModerator = isModerator;
        this.joinTime = DateConverter.iso8601DateTimeFromString(joinTime);
        this.leaveTime = DateConverter.iso8601DateTimeFromString(leaveTime);
        this.durationSeconds = durationSeconds;
        this.outboundQueueLength = outboundQueueLength;
        this.outboundTimeInQueue = outboundTimeInQueue;
        this.jitterBufferSize = jitterBufferSize;
        this.isCoach = isCoach;
        this.coachedParticipants = coachedParticipants;
        this.participantRegion = participantRegion;
        this.conferenceRegion = conferenceRegion;
        this.callType = callType;
        this.processingState = processingState;
        this.properties = properties;
        this.events = events;
        this.metrics = metrics;
        this.url = url;
    }

    /**
     * Returns SID for this participant..
     *
     * @return SID for this participant.
     */
    public final String getParticipantSid() {
        return this.participantSid;
    }

    /**
     * Returns The user-specified label of this participant..
     *
     * @return The user-specified label of this participant.
     */
    public final String getLabel() {
        return this.label;
    }

    /**
     * Returns Conference SID..
     *
     * @return Conference SID.
     */
    public final String getConferenceSid() {
        return this.conferenceSid;
    }

    /**
     * Returns Unique SID identifier of the call..
     *
     * @return Unique SID identifier of the call.
     */
    public final String getCallSid() {
        return this.callSid;
    }

    /**
     * Returns Account SID..
     *
     * @return Account SID.
     */
    public final String getAccountSid() {
        return this.accountSid;
    }

    /**
     * Returns Call direction of the participant..
     *
     * @return Call direction of the participant.
     */
    public final ConferenceParticipant.CallDirection getCallDirection() {
        return this.callDirection;
    }

    /**
     * Returns Caller ID of the calling party..
     *
     * @return Caller ID of the calling party.
     */
    public final String getFrom() {
        return this.from;
    }

    /**
     * Returns Called party..
     *
     * @return Called party.
     */
    public final String getTo() {
        return this.to;
    }

    /**
     * Returns Call status of the call that generated the participant..
     *
     * @return Call status of the call that generated the participant.
     */
    public final ConferenceParticipant.CallStatus getCallStatus() {
        return this.callStatus;
    }

    /**
     * Returns ISO alpha-2 country code of the participant..
     *
     * @return ISO alpha-2 country code of the participant.
     */
    public final String getCountryCode() {
        return this.countryCode;
    }

    /**
     * Returns Boolean. Indicates whether participant had
     * startConferenceOnEnter=true or endConferenceOnExit=true..
     *
     * @return Boolean. Indicates whether participant had
     *         startConferenceOnEnter=true or endConferenceOnExit=true.
     */
    public final Boolean getIsModerator() {
        return this.isModerator;
    }

    /**
     * Returns ISO 8601 timestamp of participant join event..
     *
     * @return ISO 8601 timestamp of participant join event.
     */
    public final ZonedDateTime getJoinTime() {
        return this.joinTime;
    }

    /**
     * Returns ISO 8601 timestamp of participant leave event..
     *
     * @return ISO 8601 timestamp of participant leave event.
     */
    public final ZonedDateTime getLeaveTime() {
        return this.leaveTime;
    }

    /**
     * Returns Participant durations in seconds..
     *
     * @return Participant durations in seconds.
     */
    public final Integer getDurationSeconds() {
        return this.durationSeconds;
    }

    /**
     * Returns Estimated time in queue at call creation..
     *
     * @return Estimated time in queue at call creation.
     */
    public final Integer getOutboundQueueLength() {
        return this.outboundQueueLength;
    }

    /**
     * Returns Actual time in queue (seconds)..
     *
     * @return Actual time in queue (seconds).
     */
    public final Integer getOutboundTimeInQueue() {
        return this.outboundTimeInQueue;
    }

    /**
     * Returns The Jitter Buffer Size of this Conference Participant..
     *
     * @return The Jitter Buffer Size of this Conference Participant.
     */
    public final ConferenceParticipant.JitterBufferSize getJitterBufferSize() {
        return this.jitterBufferSize;
    }

    /**
     * Returns Boolean. Indicated whether participant was a coach..
     *
     * @return Boolean. Indicated whether participant was a coach.
     */
    public final Boolean getIsCoach() {
        return this.isCoach;
    }

    /**
     * Returns Call SIDs coached by this participant..
     *
     * @return Call SIDs coached by this participant.
     */
    public final List<String> getCoachedParticipants() {
        return this.coachedParticipants;
    }

    /**
     * Returns Twilio region where the participant media originates..
     *
     * @return Twilio region where the participant media originates.
     */
    public final ConferenceParticipant.Region getParticipantRegion() {
        return this.participantRegion;
    }

    /**
     * Returns The Conference Region of this Conference Participant..
     *
     * @return The Conference Region of this Conference Participant.
     */
    public final ConferenceParticipant.Region getConferenceRegion() {
        return this.conferenceRegion;
    }

    /**
     * Returns The Call Type of this Conference Participant..
     *
     * @return The Call Type of this Conference Participant.
     */
    public final ConferenceParticipant.CallType getCallType() {
        return this.callType;
    }

    /**
     * Returns Processing state of the Participant Summary..
     *
     * @return Processing state of the Participant Summary.
     */
    public final ConferenceParticipant.ProcessingState getProcessingState() {
        return this.processingState;
    }

    /**
     * Returns Participant properties and metadata..
     *
     * @return Participant properties and metadata.
     */
    public final Map<String, Object> getProperties() {
        return this.properties;
    }

    /**
     * Returns Object containing information of actions taken by participants.
     * Nested resource URLs..
     *
     * @return Object containing information of actions taken by participants.
     *         Nested resource URLs.
     */
    public final Map<String, Object> getEvents() {
        return this.events;
    }

    /**
     * Returns Object. Contains participant quality metrics..
     *
     * @return Object. Contains participant quality metrics.
     */
    public final Map<String, Object> getMetrics() {
        return this.metrics;
    }

    /**
     * Returns The URL of this resource..
     *
     * @return The URL of this resource.
     */
    public final URI getUrl() {
        return this.url;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        ConferenceParticipant other = (ConferenceParticipant) o;

        return Objects.equals(participantSid, other.participantSid) &&
               Objects.equals(label, other.label) &&
               Objects.equals(conferenceSid, other.conferenceSid) &&
               Objects.equals(callSid, other.callSid) &&
               Objects.equals(accountSid, other.accountSid) &&
               Objects.equals(callDirection, other.callDirection) &&
               Objects.equals(from, other.from) &&
               Objects.equals(to, other.to) &&
               Objects.equals(callStatus, other.callStatus) &&
               Objects.equals(countryCode, other.countryCode) &&
               Objects.equals(isModerator, other.isModerator) &&
               Objects.equals(joinTime, other.joinTime) &&
               Objects.equals(leaveTime, other.leaveTime) &&
               Objects.equals(durationSeconds, other.durationSeconds) &&
               Objects.equals(outboundQueueLength, other.outboundQueueLength) &&
               Objects.equals(outboundTimeInQueue, other.outboundTimeInQueue) &&
               Objects.equals(jitterBufferSize, other.jitterBufferSize) &&
               Objects.equals(isCoach, other.isCoach) &&
               Objects.equals(coachedParticipants, other.coachedParticipants) &&
               Objects.equals(participantRegion, other.participantRegion) &&
               Objects.equals(conferenceRegion, other.conferenceRegion) &&
               Objects.equals(callType, other.callType) &&
               Objects.equals(processingState, other.processingState) &&
               Objects.equals(properties, other.properties) &&
               Objects.equals(events, other.events) &&
               Objects.equals(metrics, other.metrics) &&
               Objects.equals(url, other.url);
    }

    @Override
    public int hashCode() {
        return Objects.hash(participantSid,
                            label,
                            conferenceSid,
                            callSid,
                            accountSid,
                            callDirection,
                            from,
                            to,
                            callStatus,
                            countryCode,
                            isModerator,
                            joinTime,
                            leaveTime,
                            durationSeconds,
                            outboundQueueLength,
                            outboundTimeInQueue,
                            jitterBufferSize,
                            isCoach,
                            coachedParticipants,
                            participantRegion,
                            conferenceRegion,
                            callType,
                            processingState,
                            properties,
                            events,
                            metrics,
                            url);
    }
}