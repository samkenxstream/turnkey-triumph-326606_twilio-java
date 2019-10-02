/**
 * This code was generated by
 * \ / _    _  _|   _  _
 *  | (_)\/(_)(_|\/| |(/_  v1.0.0
 *       /       /
 */

package com.twilio.rest.taskrouter.v1.workspace.taskqueue;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.MoreObjects;
import com.twilio.base.Resource;
import com.twilio.converter.Converter;
import com.twilio.exception.ApiConnectionException;
import com.twilio.exception.ApiException;
import com.twilio.exception.RestException;
import com.twilio.http.HttpMethod;
import com.twilio.http.Request;
import com.twilio.http.Response;
import com.twilio.http.TwilioRestClient;
import com.twilio.rest.Domains;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TaskQueuesStatistics extends Resource {
    private static final long serialVersionUID = 212191647411252L;

    /**
     * Create a TaskQueuesStatisticsReader to execute read.
     *
     * @param pathWorkspaceSid The SID of the Workspace with the TaskQueues to read
     * @return TaskQueuesStatisticsReader capable of executing the read
     */
    public static TaskQueuesStatisticsReader reader(final String pathWorkspaceSid) {
        return new TaskQueuesStatisticsReader(pathWorkspaceSid);
    }

    /**
     * Converts a JSON String into a TaskQueuesStatistics object using the provided
     * ObjectMapper.
     *
     * @param json Raw JSON String
     * @param objectMapper Jackson ObjectMapper
     * @return TaskQueuesStatistics object represented by the provided JSON
     */
    public static TaskQueuesStatistics fromJson(final String json, final ObjectMapper objectMapper) {
        // Convert all checked exceptions to Runtime
        try {
            return objectMapper.readValue(json, TaskQueuesStatistics.class);
        } catch (final JsonMappingException | JsonParseException e) {
            throw new ApiException(e.getMessage(), e);
        } catch (final IOException e) {
            throw new ApiConnectionException(e.getMessage(), e);
        }
    }

    /**
     * Converts a JSON InputStream into a TaskQueuesStatistics object using the
     * provided ObjectMapper.
     *
     * @param json Raw JSON InputStream
     * @param objectMapper Jackson ObjectMapper
     * @return TaskQueuesStatistics object represented by the provided JSON
     */
    public static TaskQueuesStatistics fromJson(final InputStream json, final ObjectMapper objectMapper) {
        // Convert all checked exceptions to Runtime
        try {
            return objectMapper.readValue(json, TaskQueuesStatistics.class);
        } catch (final JsonMappingException | JsonParseException e) {
            throw new ApiException(e.getMessage(), e);
        } catch (final IOException e) {
            throw new ApiConnectionException(e.getMessage(), e);
        }
    }

    private final String accountSid;
    private final Map<String, Object> cumulative;
    private final Map<String, Object> realtime;
    private final String taskQueueSid;
    private final String workspaceSid;

    @JsonCreator
    private TaskQueuesStatistics(@JsonProperty("account_sid")
                                 final String accountSid,
                                 @JsonProperty("cumulative")
                                 final Map<String, Object> cumulative,
                                 @JsonProperty("realtime")
                                 final Map<String, Object> realtime,
                                 @JsonProperty("task_queue_sid")
                                 final String taskQueueSid,
                                 @JsonProperty("workspace_sid")
                                 final String workspaceSid) {
        this.accountSid = accountSid;
        this.cumulative = cumulative;
        this.realtime = realtime;
        this.taskQueueSid = taskQueueSid;
        this.workspaceSid = workspaceSid;
    }

    /**
     * Returns The The SID of the Account that created the resource.
     *
     * @return The SID of the Account that created the resource
     */
    public final String getAccountSid() {
        return this.accountSid;
    }

    /**
     * Returns The An object that contains the cumulative statistics for the
     * TaskQueues.
     *
     * @return An object that contains the cumulative statistics for the TaskQueues
     */
    public final Map<String, Object> getCumulative() {
        return this.cumulative;
    }

    /**
     * Returns The An object that contains the real-time statistics for the
     * TaskQueues.
     *
     * @return An object that contains the real-time statistics for the TaskQueues
     */
    public final Map<String, Object> getRealtime() {
        return this.realtime;
    }

    /**
     * Returns The The SID of the TaskQueue from which these statistics were
     * calculated.
     *
     * @return The SID of the TaskQueue from which these statistics were calculated
     */
    public final String getTaskQueueSid() {
        return this.taskQueueSid;
    }

    /**
     * Returns The The SID of the Workspace that contains the TaskQueues.
     *
     * @return The SID of the Workspace that contains the TaskQueues
     */
    public final String getWorkspaceSid() {
        return this.workspaceSid;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        TaskQueuesStatistics other = (TaskQueuesStatistics) o;

        return Objects.equals(accountSid, other.accountSid) &&
               Objects.equals(cumulative, other.cumulative) &&
               Objects.equals(realtime, other.realtime) &&
               Objects.equals(taskQueueSid, other.taskQueueSid) &&
               Objects.equals(workspaceSid, other.workspaceSid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountSid,
                            cumulative,
                            realtime,
                            taskQueueSid,
                            workspaceSid);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                          .add("accountSid", accountSid)
                          .add("cumulative", cumulative)
                          .add("realtime", realtime)
                          .add("taskQueueSid", taskQueueSid)
                          .add("workspaceSid", workspaceSid)
                          .toString();
    }
}