import pytest


@pytest.fixture
def initialize_list():
    list_num = list(range(11))
    return list_num