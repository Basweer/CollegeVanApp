package com.zenex.collegevan.database

object DatabaseSeeder {

    suspend fun seed(database: AppDatabase) {

        database.driverDao().insertDrivers(
            listOf(
                DriverEntity("DR1", "Driver 1", "", "VAN001"),
                DriverEntity("DR2", "Driver 2", "", "VAN002"),
                DriverEntity("DR3", "Driver 3", "", "VAN003"),
                DriverEntity("DR4", "Driver 4", "", "VAN004")
            )
        )

        database.vanDao().insertVans(
            listOf(
                VanEntity(
                    "VAN001",
                    "AP01-001",
                    "DR1",
                    "Driver 1",
                    "Route 1"
                ),
                VanEntity(
                    "VAN002",
                    "AP01-002",
                    "DR2",
                    "Driver 2",
                    "Route 2"
                ),
                VanEntity(
                    "VAN003",
                    "AP01-003",
                    "DR3",
                    "Driver 3",
                    "Route 3"
                ),
                VanEntity(
                    "VAN004",
                    "AP01-004",
                    "DR4",
                    "Driver 4",
                    "Route 4"
                )
            )
        )
    }
}