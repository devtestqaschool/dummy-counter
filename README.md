# dummy-counter

The main purpose of the application is to teach to find bugs, using logs and looking for the bugs in logs.

## How to configure

In application.properties file some properties are present

| Propery | Default Value | Description |
|---|---|---|
| logging.level.com.dummycounter.dummycounter | TRACE | Configure how much logs should be product my application |
| dummycounter.bug.incrementValue | 1 | Configure the increment power |
| dummycounter.bug.initialValue | 0 | Configure the initial value of counter |
| dummycounter.bug.resetValue | 0 | Configure the value after a counter reset |
| dummycounter.bug.canDelete | true | Configure whether counters may be deleted |
| server.port | 18564 | Configure port that is being listened by Tomcat |
