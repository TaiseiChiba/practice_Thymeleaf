CREATE TABLE user (
    id BIGINT NOT NULL AUTO_INCREMENT,
    name VARCHAR(100) NOT NULL,
    address VARCHAR(255) NULL,
    phone VARCHAR(50) NULL,
    update_date DATETIME NOT NULL,
    create_date DATETIME NOT NULL,
    delete_date DATETIME NULL,
    PRIMARY KEY (id)
);

INSERT INTO user (id, name, address, phone, update_date, create_date) VALUES (
    '1', 'テスト太郎', '東京都品川区1-1', '090-0000-0000', '2021/06/30', '2021/06/30');
INSERT INTO user (id, name, address, phone, update_date, create_date) VALUES (
    '2', 'テスト次郎', '東京都渋谷区1-1', '080-0000-0000', '2021/06/30', '2021/06/30');

