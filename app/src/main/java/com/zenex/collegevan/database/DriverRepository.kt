package com.zenex.collegevan.database

class DriverRepository(
    private val driverDao: DriverDao
) {

    suspend fun loginDriver(
        driverId: String,
        password: String
    ): DriverEntity? {
        return driverDao.loginDriver(
            driverId = driverId,
            password = password
        )
    }

    suspend fun getDriver(
        driverId: String
    ): DriverEntity? {
        return driverDao.getDriver(driverId)
    }
}