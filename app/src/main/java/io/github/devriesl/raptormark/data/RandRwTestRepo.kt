package io.github.devriesl.raptormark.data

import io.github.devriesl.raptormark.Constants.RAND_RW_TEST_ID
import io.github.devriesl.raptormark.R
import io.github.devriesl.raptormark.di.StringProvider

class RandRwTestRepo(
    stringProvider: StringProvider,
    settingDataSource: SettingDataSource
) : TestRepository(stringProvider, settingDataSource) {
    override val testFileName = RAND_RW_TEST_ID

    override fun getTestName(): String {
        return stringProvider.getString(R.string.rand_rw_test_title)
    }
}