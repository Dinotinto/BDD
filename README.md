# D'tinto Water dashboard: BDD UI tests

Cucumber + Selenium 4 tests for the [D'tinto Water dashboard](https://dtinto-water-dashboard.web.app),
written in plain-English Gherkin and backed by page objects.

## What's covered

| Feature | Scenarios |
|---|---|
| `login.feature` | Login screen shows when signed out · empty form isn't submitted · unregistered account is rejected · test account logs in · logout returns to the login screen |
| `navigation.feature` | Each bottom-bar tab opens the right section and updates `?tab=` · More menu opens, closes, and opens a section · header Back button returns to the previous section · the open section survives a refresh |

Scenarios tagged `@auth` need a real account; everything else runs without one.

## Test account

Credentials are **never** stored in this repo or in the feature files. Provide them as environment variables:

| Variable | Purpose |
|---|---|
| `WATER_EMAIL` | Email of a dedicated test account (staff role or higher) |
| `WATER_PASSWORD` | Its password |

If they're not set, `@auth` scenarios are **skipped**, not failed.

Use a separate test user rather than a real staff account, since the tests log in and out repeatedly.

## Running locally

Needs Java 17+ and Maven. Chrome must be installed; Selenium downloads the matching driver itself.

```bash
export WATER_EMAIL=...        # optional
export WATER_PASSWORD=...     # optional
mvn test                                              # everything
mvn test -Dcucumber.filter.tags="@login and not @auth" # no account needed
mvn test -Dcucumber.filter.tags="@navigation"
```

The report is written to `target/cucumber-report.html`, with a screenshot attached to any failed step.

### Other settings

| Variable | Default | Notes |
|---|---|---|
| `BASE_URL` | `https://dtinto-water-dashboard.web.app` | e.g. `http://localhost:5173` against `npm run dev` |
| `BROWSER` | `chrome` | `firefox` or `edge` also work |
| `HEADLESS` | `true` on CI, `false` locally | |
| `WINDOW_SIZE` | `412,915` | Phone-sized by default; try `1366,900` for desktop |
| `TIMEOUT_SECONDS` | `30` | How long to wait for login and data loading |

## CI

`.github/workflows/ui-tests.yml` runs on every push and pull request, on weekday mornings, and on demand
(with an optional tag filter). Add `WATER_EMAIL` and `WATER_PASSWORD` under
**Settings → Secrets and variables → Actions** to include the logged-in scenarios.
The HTML report is uploaded as a build artifact.

## Layout

```
src/test/java/water/
  RunCucumberTest.java      suite entry point
  pages/                    LoginPage, AppShell (top bar, bottom bar, More drawer)
  steps/                    LoginSteps, NavigationSteps
  support/                  Config (env vars), DriverFactory, TestContext, Hooks
src/test/resources/features/
  login.feature
  navigation.feature
```
