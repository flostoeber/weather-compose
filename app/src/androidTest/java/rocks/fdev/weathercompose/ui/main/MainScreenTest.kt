package rocks.fdev.weathercompose.ui.main

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import rocks.fdev.weathercompose.R

@HiltAndroidTest
class MainScreenTest {
    @get:Rule(order = 0)
    var hiltRule = HiltAndroidRule(this)

    @get:Rule(order = 1)
    val composeTestRule = createAndroidComposeRule<MainActivity>()

    @Before
    fun setup() {
        composeTestRule.setContent {
            MainScreen()
        }
    }

    @Test
    fun app_launches() {
        val appName = composeTestRule.activity.getText(R.string.app_name).toString()
        composeTestRule.onNodeWithText(appName).assertIsDisplayed()
    }

    @Test
    fun app_opens_detail() {
        composeTestRule.onNodeWithText("-2", substring = true, ignoreCase = true).performClick()
        // TODO: interop with idlingResource to wait until everything is idling
        composeTestRule.onNodeWithText("Sat, 20.3.").assertIsDisplayed()
    }
}
