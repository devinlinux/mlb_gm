import os
import pandas as pd

pitchers_dataset = pd.read_csv(os.path.join('data_pruning', 'war_daily_pitch.csv'))
batters_dataset = pd.read_csv(os.path.join('data_pruning', 'war_daily_bat.csv'))

pitchers_dataset = pitchers_dataset[['name_common', 'year_ID', 'team_ID']]
batters_dataset = batters_dataset[['name_common', 'year_ID', 'team_ID']]

full_dataset = pd.concat([pitchers_dataset, batters_dataset], ignore_index=True)

full_dataset_2023 = full_dataset[full_dataset['year_ID'] == 2023]
full_dataset_2019 = full_dataset[full_dataset['year_ID'] == 2019]

full_dataset_2023.drop('year_ID', axis=1)
full_dataset_2019.drop('year_ID', axis=1)

full_dataset.to_csv(os.path.join('data', 'players', 'all_players.csv'), index=False)
full_dataset_2023.to_csv(os.path.join('data', 'players', '2023_players.csv'), index=False)
full_dataset_2019.to_csv(os.path.join('data', 'players', '2019_players.csv'), index=False)