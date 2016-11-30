
% 2016-10-17 21:40:31

% 17_10_uncertainty_log_f8_n3_t30/NetworkCharacUncertainty/0.3_0.0/
max_time = 6;
max_flows = 1;
max_nets = 1;
max_rep = 10;
evaluate_max_only = 1;

scheduler_logs= {'Optimization_log.m',  'true_adapted.m', 'Greedy_0_H2_log.m', 'GreedyOnline_H2_log.m', 'GreedyOnlineOpp_0_H2_log.m', 'Random_log.m'};
schedulers= {'Optimal', 'GA(True)', 'Greedy', 'GreedyOnline', 'GreedyOnlineOpp', 'Random'};
