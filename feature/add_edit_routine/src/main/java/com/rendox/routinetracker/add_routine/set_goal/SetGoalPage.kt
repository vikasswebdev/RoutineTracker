package com.rendox.routinetracker.add_routine.set_goal

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import com.rendox.routinetracker.add_routine.AddRoutineDestinationTopAppBar
import com.rendox.routinetracker.add_routine.navigation.AddRoutineDestination
import com.rendox.routinetracker.feature.agenda.R

@Composable
fun SetGoalPage(
    modifier: Modifier = Modifier,
    setGoalPageState: SetGoalPageState,
) {
    Column(modifier = modifier) {
        AddRoutineDestinationTopAppBar(destination = AddRoutineDestination.SetGoal)

        OutlinedTextField(
            modifier = Modifier
                .padding(top = 16.dp, start = 16.dp, end = 16.dp)
                .fillMaxWidth(),
            value = setGoalPageState.routineName,
            onValueChange = setGoalPageState::updateRoutineName,
            keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next),
            label = {
                Text(
                    text = stringResource(
                        id = R.string.set_goal_page_routine_name_text_field_label
                    )
                )
            },
            singleLine = true,
            isError = !setGoalPageState.routineNameIsValid,
            supportingText = {
                if (!setGoalPageState.routineNameIsValid) {
                    Text(
                        text = stringResource(
                            id = R.string.set_goal_page_empty_routine_name_error_message
                        )
                    )
                }
            }
        )

        OutlinedTextField(
            modifier = Modifier
                .padding(top = 16.dp, start = 16.dp, end = 16.dp)
                .fillMaxWidth(),
            value = setGoalPageState.routineDescription ?: "",
            onValueChange = setGoalPageState::updateRoutineDescription,
            label = {
                Text(
                    text = stringResource(
                        id = R.string.set_goal_page_routine_description_text_field_label
                    )
                )
            },
        )
    }
}