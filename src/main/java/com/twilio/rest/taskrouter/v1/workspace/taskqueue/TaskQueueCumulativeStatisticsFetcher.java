/**
 * This code was generated by
 * \ / _    _  _|   _  _
 *  | (_)\/(_)(_|\/| |(/_  v1.0.0
 *       /       /
 */

package com.twilio.rest.taskrouter.v1.workspace.taskqueue;

import com.twilio.base.Fetcher;
import com.twilio.converter.DateConverter;
import com.twilio.exception.ApiConnectionException;
import com.twilio.exception.ApiException;
import com.twilio.exception.RestException;
import com.twilio.http.HttpMethod;
import com.twilio.http.Request;
import com.twilio.http.Response;
import com.twilio.http.TwilioRestClient;
import com.twilio.rest.Domains;

import java.time.ZonedDateTime;

public class TaskQueueCumulativeStatisticsFetcher extends Fetcher<TaskQueueCumulativeStatistics> {
    private final String pathWorkspaceSid;
    private final String pathTaskQueueSid;
    private ZonedDateTime endDate;
    private Integer minutes;
    private ZonedDateTime startDate;
    private String taskChannel;
    private String splitByWaitTime;

    /**
     * Construct a new TaskQueueCumulativeStatisticsFetcher.
     *
     * @param pathWorkspaceSid The SID of the Workspace with the TaskQueue to fetch
     * @param pathTaskQueueSid The SID of the TaskQueue for which to fetch
     *                         statistics
     */
    public TaskQueueCumulativeStatisticsFetcher(final String pathWorkspaceSid,
                                                final String pathTaskQueueSid) {
        this.pathWorkspaceSid = pathWorkspaceSid;
        this.pathTaskQueueSid = pathTaskQueueSid;
    }

    /**
     * Only calculate statistics from this date and time and earlier, specified in
     * GMT as an <a href="https://en.wikipedia.org/wiki/ISO_8601">ISO 8601</a>
     * date-time..
     *
     * @param endDate Only calculate statistics from on or before this date
     * @return this
     */
    public TaskQueueCumulativeStatisticsFetcher setEndDate(final ZonedDateTime endDate) {
        this.endDate = endDate;
        return this;
    }

    /**
     * Only calculate statistics since this many minutes in the past. The default is
     * 15 minutes..
     *
     * @param minutes Only calculate statistics since this many minutes in the past
     * @return this
     */
    public TaskQueueCumulativeStatisticsFetcher setMinutes(final Integer minutes) {
        this.minutes = minutes;
        return this;
    }

    /**
     * Only calculate statistics from this date and time and later, specified in <a
     * href="https://en.wikipedia.org/wiki/ISO_8601">ISO 8601</a> format..
     *
     * @param startDate Only calculate statistics from on or after this date
     * @return this
     */
    public TaskQueueCumulativeStatisticsFetcher setStartDate(final ZonedDateTime startDate) {
        this.startDate = startDate;
        return this;
    }

    /**
     * Only calculate cumulative statistics on this TaskChannel. Can be the
     * TaskChannel's SID or its `unique_name`, such as `voice`, `sms`, or
     * `default`..
     *
     * @param taskChannel Only calculate cumulative statistics on this TaskChannel
     * @return this
     */
    public TaskQueueCumulativeStatisticsFetcher setTaskChannel(final String taskChannel) {
        this.taskChannel = taskChannel;
        return this;
    }

    /**
     * A comma separated list of values that describes the thresholds, in seconds,
     * to calculate statistics on. For each threshold specified, the number of Tasks
     * canceled and reservations accepted above and below the specified thresholds
     * in seconds are computed. TaskRouter will calculate statistics on up to 10,000
     * Tasks/Reservations for any given threshold..
     *
     * @param splitByWaitTime A comma separated list of values that describes the
     *                        thresholds, in seconds, to calculate statistics on
     * @return this
     */
    public TaskQueueCumulativeStatisticsFetcher setSplitByWaitTime(final String splitByWaitTime) {
        this.splitByWaitTime = splitByWaitTime;
        return this;
    }

    /**
     * Make the request to the Twilio API to perform the fetch.
     *
     * @param client TwilioRestClient with which to make the request
     * @return Fetched TaskQueueCumulativeStatistics
     */
    @Override
    @SuppressWarnings("checkstyle:linelength")
    public TaskQueueCumulativeStatistics fetch(final TwilioRestClient client) {
        Request request = new Request(
            HttpMethod.GET,
            Domains.TASKROUTER.toString(),
            "/v1/Workspaces/" + this.pathWorkspaceSid + "/TaskQueues/" + this.pathTaskQueueSid + "/CumulativeStatistics"
        );

        addQueryParams(request);
        Response response = client.request(request);

        if (response == null) {
            throw new ApiConnectionException("TaskQueueCumulativeStatistics fetch failed: Unable to connect to server");
        } else if (!TwilioRestClient.SUCCESS.test(response.getStatusCode())) {
            RestException restException = RestException.fromJson(response.getStream(), client.getObjectMapper());
            if (restException == null) {
                throw new ApiException("Server Error, no content");
            }
            throw new ApiException(restException);
        }

        return TaskQueueCumulativeStatistics.fromJson(response.getStream(), client.getObjectMapper());
    }

    /**
     * Add the requested query string arguments to the Request.
     *
     * @param request Request to add query string arguments to
     */
    private void addQueryParams(final Request request) {
        if (endDate != null) {
            request.addQueryParam("EndDate", endDate.toInstant().toString());
        }

        if (minutes != null) {
            request.addQueryParam("Minutes", minutes.toString());
        }

        if (startDate != null) {
            request.addQueryParam("StartDate", startDate.toInstant().toString());
        }

        if (taskChannel != null) {
            request.addQueryParam("TaskChannel", taskChannel);
        }

        if (splitByWaitTime != null) {
            request.addQueryParam("SplitByWaitTime", splitByWaitTime);
        }
    }
}