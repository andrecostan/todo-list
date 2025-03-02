CREATE KEYSPACE IF NOT EXISTS todolist
    WITH replication = {
        'class': 'NetworkTopologyStrategy',
        'datacenter1': 1
        } AND TABLETS = {'enabled': false};

USE todolist;

CREATE TABLE IF NOT EXISTS tasks
(
    id          UUID PRIMARY KEY,
    title       TEXT,
    description TEXT,
    completed   BOOLEAN
);
