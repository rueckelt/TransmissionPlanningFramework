
% 2015-10-17 01:29:14

% my_logs\longTest1\0_1_2\rep_9\priority_log.m
scheduling_duration_us = 34919;

% schedule
schedule_f_t_n(:,:,1) = [6, 0, 0, 0; 6, 0, 0, 0; 6, 0, 0, 0; 6, 0, 0, 0; 6, 0, 0, 0; 6, 0, 0, 0; 6, 0, 0, 0; 0, 6, 0, 0; 0, 6, 0, 0; 0, 6, 0, 0; 0, 6, 0, 0; 0, 6, 0, 0; 0, 6, 0, 0; 0, 6, 0, 0; 0, 6, 0, 0; 0, 6, 0, 0; 0, 6, 0, 0; 0, 6, 0, 0; 6, 0, 0, 0; 6, 0, 0, 0; 6, 0, 0, 0; 6, 0, 0, 0; 6, 0, 0, 0; 6, 0, 0, 0; 6, 0, 0, 0; 6, 0, 0, 0; 4, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 6; 0, 0, 0, 6; 0, 0, 0, 6; 0, 0, 0, 6; 0, 0, 0, 6; 0, 0, 0, 6; 0, 0, 0, 6; 0, 0, 0, 6; 0, 0, 0, 6; 0, 0, 0, 6; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0];

% cost function results
vioSt = [0];
vioDl = [0];
vioNon = [0];
vioTpMin = [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 4, 4, 4, 4, 4, 4, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0];
vioTp = [2800];
vioLcy = [37856];
vioJit = [23600];
cost_vio = 578304;
cost_switches = 600;
cost_ch = 1162;
costTotal = 580066;

% priority
% 
% ############### Network 0 ##############
% F0	|[0]6	|6	|6	|6	|6	|6	|6	|	|	|	|[10]	|	|	|	|	|	|	|	|6	|6	|[20]6	|6	|6	|6	|6	|6	|4	|	|	|	|[30]	|	|	|	|	|	|	|	|	|	|[40]	|	|	|	|	|	|	|	|	|	|
% ############### Network 1 ##############
% F0	|[0]	|	|	|	|	|	|	|6	|6	|6	|[10]6	|6	|6	|6	|6	|6	|6	|6	|	|	|[20]	|	|	|	|	|	|	|	|	|	|[30]	|	|	|	|	|	|	|	|	|	|[40]	|	|	|	|	|	|	|	|	|	|
% ############### Network 2 ##############
% ############### Network 3 ##############
% F0	|[0]	|	|	|	|	|	|	|	|	|	|[10]	|	|	|	|	|	|	|	|	|	|[20]	|	|	|	|	|	|	|	|	|	|[30]	|	|	|	|6	|6	|6	|6	|6	|6	|[40]6	|6	|6	|6	|	|	|	|	|	|	|
