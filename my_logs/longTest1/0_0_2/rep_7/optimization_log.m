
% 2015-10-17 01:05:40

% my_logs\longTest1\0_0_2\rep_7\optimization_log.m
scheduling_duration_us = 99128;

% schedule
schedule_f_t_n(:,:,1) = [0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 5; 0, 0, 0, 5; 0, 0, 0, 5; 0, 0, 0, 5; 0, 0, 0, 5; 0, 0, 0, 5; 0, 0, 0, 5; 0, 0, 0, 5; 0, 0, 0, 5; 0, 0, 0, 5; 0, 0, 0, 0; 5, 0, 0, 0; 4, 0, 0, 0; 5, 0, 0, 0; 5, 0, 0, 0; 5, 0, 0, 0; 5, 0, 0, 0; 5, 0, 0, 0; 5, 0, 0, 0; 5, 0, 0, 0; 5, 0, 0, 0; 5, 0, 0, 0; 0, 0, 0, 0];

% cost function results
vioSt = [0];
vioDl = [0];
vioNon = [0];
vioTpMin = [5, 5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 5, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0];
vioTp = [1600];
vioLcy = [6048];
vioJit = [6096];
cost_vio = 151184;
cost_switches = 200;
cost_ch = 794;
costTotal = 152178;

% optimization
% 
% ############### Network 0 ##############
% F0	|[0]	|	|	|	|	|	|	|	|	|	|[10]	|	|	|5	|4	|5	|5	|5	|5	|5	|[20]5	|5	|5	|5	|	|
% ############### Network 1 ##############
% ############### Network 2 ##############
% ############### Network 3 ##############
% F0	|[0]	|	|5	|5	|5	|5	|5	|5	|5	|5	|[10]5	|5	|	|	|	|	|	|	|	|	|[20]	|	|	|	|	|
