
% 2015-10-17 01:24:13

% my_logs\longTest1\1_1_1\rep_29\optimization_log.m
scheduling_duration_us = 568584;

% schedule
schedule_f_t_n(:,:,1) = [0, 0; 0, 0; 0, 0; 0, 0; 0, 0; 0, 0; 0, 0; 0, 0; 0, 0; 0, 0; 0, 0; 0, 0; 0, 0; 0, 0; 0, 0; 0, 0; 0, 0; 0, 0; 0, 0; 0, 0; 0, 0; 0, 0; 0, 0; 0, 0; 0, 0; 0, 5; 0, 5; 0, 5; 0, 5; 0, 5; 0, 5; 0, 0; 0, 0; 0, 0; 0, 0; 0, 0; 0, 0; 0, 0; 0, 0; 0, 0; 0, 0; 0, 0; 0, 0; 0, 0; 0, 0; 0, 0; 0, 0; 0, 0; 0, 0; 0, 0];
schedule_f_t_n(:,:,2) = [1, 0; 1, 0; 1, 0; 1, 0; 1, 0; 1, 0; 1, 0; 1, 0; 1, 0; 1, 0; 1, 0; 1, 0; 1, 0; 1, 0; 1, 0; 1, 0; 1, 0; 1, 0; 3, 0; 1, 0; 1, 0; 1, 0; 1, 0; 0, 0; 1, 0; 1, 0; 0, 0; 0, 0; 0, 0; 0, 0; 0, 0; 0, 0; 0, 0; 0, 0; 0, 0; 0, 0; 0, 0; 0, 0; 0, 0; 0, 0; 0, 0; 0, 0; 0, 0; 0, 0; 0, 0; 0, 0; 0, 0; 0, 0; 0, 0; 0, 0];

% cost function results
vioSt = [0, 0];
vioDl = [0, 0];
vioNon = [7238, 0];
vioTpMin = [5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0];
vioTp = [12500, 0];
vioLcy = [0, 0];
vioJit = [2880, 0];
cost_vio = 248798;
cost_switches = 0;
cost_ch = 249;
costTotal = 249047;

% optimization
% 
% ############### Network 0 ##############
% F1	|[0]1	|1	|1	|1	|1	|1	|1	|1	|1	|1	|[10]1	|1	|1	|1	|1	|1	|1	|1	|3	|1	|[20]1	|1	|1	|	|1	|1	|	|	|	|	|[30]	|	|	|	|	|	|	|	|	|	|[40]	|	|	|	|	|	|	|	|	|	|
% ############### Network 1 ##############
% F0	|[0]	|	|	|	|	|	|	|	|	|	|[10]	|	|	|	|	|	|	|	|	|	|[20]	|	|	|	|	|5	|5	|5	|5	|5	|[30]5	|	|	|	|	|	|	|	|	|	|[40]	|	|	|	|	|	|	|	|	|	|
